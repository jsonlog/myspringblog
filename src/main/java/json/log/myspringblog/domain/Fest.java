package json.log.myspringblog.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jsonlog
 * @date 2019-04-30
 */
public class Fest implements Serializable {

    private Long id;
    private String timing;
    private Date cal;

    public Fest() {
        super();
    }

    public Fest(Date cal,String timing) {
        super();
        this.timing = timing;
        this.cal = cal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public Date getCal() {
        return cal;
    }

    public void setCal(Date cal) {
        this.cal = cal;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Fest [id=" + this.id + ", cal=" + this.cal + ", timing=" + timing + "]";
    }

}