package wenhao.bawie.com.lianfenlei;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import wenhao.bawie.com.lianfenlei.greendao.DaoMaster;
import wenhao.bawie.com.lianfenlei.greendao.NewsBeanDao;

/**
 * Created by HP on 2018/11/3.
 */

public class NewsBeanUtils {

    private DaoMaster.DevOpenHelper helper;
    private NewsBeanDao newsDao;

    private NewsBeanUtils(){}
    private static NewsBeanUtils mNewsBeanUtils;
    public static NewsBeanUtils getmNewsBeanUtils(){
        if (mNewsBeanUtils==null){
            mNewsBeanUtils = new NewsBeanUtils();
        }
        return mNewsBeanUtils;
    }

    //初始化
    public void init(Context context){
        helper = new DaoMaster.DevOpenHelper(context, "news");
        SQLiteDatabase db = helper.getWritableDatabase();
        newsDao = new DaoMaster(db).newSession().getNewsBeanDao();
    }
    //添加
    public void insert(NewsBean msg){
        newsDao.insert(msg);
    }
    //查询
    public List<NewsBean> queryAll(){
        return  newsDao.loadAll();
    }
    //删除
    public void deleteAll(){
        newsDao.deleteAll();
    }
}
