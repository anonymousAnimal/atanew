package com.ata.util;

import com.ata.bean.CredentialsBean;
import com.ata.bean.ProfileBean;

public interface User {
String login(CredentialsBean credentialsBean);
boolean logout(String userId) ;
String changePassword(CredentialsBean credentialsBean, String newPassword) ;
String register(ProfileBean profileBean);
}
