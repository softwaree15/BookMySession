package com.bookmysession.service;

import com.bookmysession.enumModel.UserType;
import com.bookmysession.model.Users;
import com.bookmysession.repositories.UserRepository;
import com.bookmysession.utils.BaseUtils;
import com.bookmysession.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Transactional
public class UserService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private Pattern pattern;
    private Matcher matcher;
    Random rand = new Random();

    @Autowired
    UserRepository userRepository;

    public Users createUser(Users user)
    {
        if (!isUserValid(user,0))
        {
            throw  new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, StringUtils.DATA_NOT_SET_PROPERLY);
        }
        else if (userRepository.getUserByEmail(user.getEmail()).isPresent())
        {
            throw  new ResponseStatusException(HttpStatus.ALREADY_REPORTED, StringUtils.DATA_ALREADY_EXIST);
        }
        user.setType(UserType.USER.toString());
        user.setToken(BaseUtils.MD5(tokenHashGenrate()));
        user.setPassword(BaseUtils.MD5(user.getPassword()));
        user.setTokenExpireDate(LocalDateTime.now().plusDays(15));
        return userRepository.save(user);
    }
    public Users login(Users user)
    {
        Users foundUser=userRepository.getUserByemailAndPassword(user.getEmail(),BaseUtils.MD5(user.getPassword()));
        if (foundUser==null)
        {
            throw  new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,StringUtils.DATA_NOT_EXIST);
        }
        foundUser.setToken(BaseUtils.MD5(tokenHashGenrate()));
        foundUser.setTokenExpireDate(LocalDateTime.now().plusDays(15));
        return userRepository.save(foundUser);
    }
    public List<Users> getAllUser()
    {
        Optional<List<Users>> usersList=userRepository.getAllByActive();
        if (!usersList.isPresent())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,StringUtils.DATA_NOT_EXIST);
        }
        return usersList.get();
    }
    public Users getUserById(long id)
    {
        Optional<Users> user=userRepository.getByIdAndActive(id);
        if (!user.isPresent())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,StringUtils.DATA_NOT_EXIST);
        }
        return user.get();
    }


    public boolean isUserValid(Users user,long userId)
    {
        if ((user.getFirstName()==null || user.getLastName()==null) || (user.getFirstName().isEmpty() || user.getLastName().isEmpty()))
        {
            return false;
        }
        else if (user.getPassword()==null ||  user.getPassword().isEmpty())
        {
            return false;
        }
        else if(user.getEmail()==null || user.getEmail().isEmpty())
        {
            return false;
        }
        else if(!validateEmail(user.getEmail()))
        {
            return false;
        }
        else if(userId>0)
        {
            if (user.getId()==0)
            {
                return false;
            }
        }
        return true;
    }
    public boolean validateEmail(String email) {
        System.out.println(email);
        pattern = Pattern.compile(StringUtils.EMAIL_REGEX);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public String tokenHashGenrate()
    {
        String strForToken="aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ1234567890";
        String token="";
        for (int i=0;i<8;i++)
        {
            token += strForToken.charAt(rand.nextInt(strForToken.length()-1));
        }
        token=token+ LocalDateTime.now().toString();
        return token;
    }
}
