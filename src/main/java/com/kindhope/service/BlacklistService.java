package com.kindhope.service;

import com.kindhope.entity.Blacklist;
import com.kindhope.entity.BlacklistPK;
import com.kindhope.entity.User;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public interface BlacklistService extends GenericPKService<Blacklist, BlacklistPK>, GenericService<Blacklist> {
    List<User> findUserBlacklist(BigInteger userId);

    List<User> findPeopleWhoBlockedUser(BigInteger userId);

}
