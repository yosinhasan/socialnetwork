package com.kindhope.dao.impl;

import com.kindhope.dao.DeletedConversationDAO;
import com.kindhope.entity.DeletedConversation;
import com.kindhope.entity.DeletedConversationPK;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yosin_Hasan<yosinhasan@gmail.com>
 * @version 0.0.1
 */
@Repository
public class DeletedConversationDAOImpl extends AbstractPKDAOImpl<DeletedConversation, DeletedConversationPK> implements DeletedConversationDAO {
    private static final Logger LOG = Logger.getLogger(DeletedConversationDAOImpl.class);

    @Transactional
    @Override
    public List<DeletedConversation> readAll() {
        return getSession().createQuery("select dc from DeletedConversation dc").getResultList();
    }

    @Transactional
    @Override
    public DeletedConversation read(Class<DeletedConversation> deletedConversationClass, DeletedConversationPK deletedConversationPK) {
        return getSession().get(DeletedConversation.class, deletedConversationPK);
    }

}
