package com.kindhope.service;

import com.kindhope.entity.ConnectionRequest;
import com.kindhope.entity.ConnectionRequestPK;
import com.kindhope.entity.User;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
public interface ConnectionRequestService extends GenericPKService<ConnectionRequest, ConnectionRequestPK>, GenericService<ConnectionRequest> {
    List<User> findReceivedRequests(BigInteger userId);

    List<User> findSentRequests(BigInteger userId);

    void removeRequest(BigInteger userId, BigInteger requestId);

    void restoreRequest(BigInteger userId, BigInteger requestId);

    Long countRequests(BigInteger userId);

}
