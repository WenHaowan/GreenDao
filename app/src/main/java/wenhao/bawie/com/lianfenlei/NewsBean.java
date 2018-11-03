package wenhao.bawie.com.lianfenlei;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by HP on 2018/11/3.
 */

@Entity
public class NewsBean {
    @Id(autoincrement = true)
    private Long id;
    private String msg;
    @Generated(hash = 1761548526)
    public NewsBean(Long id, String msg) {
        this.id = id;
        this.msg = msg;
    }
    @Generated(hash = 1662878226)
    public NewsBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMsg() {
        return this.msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
