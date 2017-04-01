package com.kindhope.service.impl;

import com.kindhope.dao.DeletedConversationDAO;
import com.kindhope.entity.DeletedConversation;
import com.kindhope.entity.DeletedConversationPK;
import com.kindhope.service.DeletedConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Service
public class DeletedConversationServiceImpl implements DeletedConversationService {
    @Autowired
    private DeletedConversationDAO DeletedConversationDAO;

    @Override
    public DeletedConversation read(BigInteger id) {
        return DeletedConversationDAO.read(DeletedConversation.class, id);
    }

    @Override
    public BigInteger create(DeletedConversation object) {
        return DeletedConversationDAO.create(object);
    }

    @Override
    public void update(DeletedConversation object) {
        DeletedConversationDAO.update(object);
    }

    @Override
    public void delete(Object object) {
        DeletedConversationDAO.delete(object);
    }

    @Override
    public List<DeletedConversation> readAll() {
        return DeletedConversationDAO.readAll();
    }

    @Override
    public DeletedConversation read(Class<DeletedConversation> DeletedConversationClass, DeletedConversationPK DeletedConversationPK) {
        return DeletedConversationDAO.read(DeletedConversationClass, DeletedConversationPK);
    }

    @Override
    public DeletedConversationPK save(DeletedConversation object) {
        return DeletedConversationDAO.save(object);
    }
}
