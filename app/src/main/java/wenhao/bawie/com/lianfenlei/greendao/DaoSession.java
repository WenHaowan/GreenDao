package wenhao.bawie.com.lianfenlei.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import wenhao.bawie.com.lianfenlei.NewsBean;

import wenhao.bawie.com.lianfenlei.greendao.NewsBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig newsBeanDaoConfig;

    private final NewsBeanDao newsBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        newsBeanDaoConfig = daoConfigMap.get(NewsBeanDao.class).clone();
        newsBeanDaoConfig.initIdentityScope(type);

        newsBeanDao = new NewsBeanDao(newsBeanDaoConfig, this);

        registerDao(NewsBean.class, newsBeanDao);
    }
    
    public void clear() {
        newsBeanDaoConfig.clearIdentityScope();
    }

    public NewsBeanDao getNewsBeanDao() {
        return newsBeanDao;
    }

}
