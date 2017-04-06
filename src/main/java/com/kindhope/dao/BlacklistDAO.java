package com.kindhope.dao;

import com.kindhope.entity.Blacklist;
import com.kindhope.entity.BlacklistPK;
import com.kindhope.entity.User;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public interface BlacklistDAO extends GenericDAO<Blacklist>, GenericPKDAO<Blacklist, BlacklistPK> {

    List<User> findUserBlacklist(BigInteger userId);

    List<User> findPeopleWhoBlockedUser(BigInteger userId);

}
