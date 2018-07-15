import domain.User;

import java.io.Serializable;

/**
 * 服务器/客户端之间发送的对象数据
 *
 * packType - 表示此次发送的请求类型，如（开课/选课/登录/注册）等，详情请看枚举类型 PackType
 * result - 服务器返回此对象时，可用此字段表示是否成功
 * user - 操作的用户
 * data - 附带数据，如User对象、Course对象以及Java集合等，若无附加数据则传递null即可
 *
 */

public class Pack implements Serializable {
    private PackType packType;
    private boolean result;
    private User operator;
    private Object data;

    public Pack(PackType packType, boolean result, Object data) {
        this.packType = packType;
        this.result = result;
        this.data = data;
    }

    public PackType getPackType() {
        return packType;
    }

    public void setPackType(PackType packType) {
        this.packType = packType;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public User getOperator() {
        return operator;
    }

    public void setOperator(User operator) {
        this.operator = operator;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
