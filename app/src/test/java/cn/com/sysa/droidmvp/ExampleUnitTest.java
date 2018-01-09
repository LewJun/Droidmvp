package cn.com.sysa.droidmvp;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.junit.Test;

import java.lang.reflect.Type;

import cn.com.sysa.droidmvp.net.ApiResult;
import cn.com.sysa.droidmvp.model.ServerModel;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        String jsonTxt = "{\"data\":{\"author\":{\"des\":\"欢迎下载使用OkHttpUtils网络框架，如果遇到问题，欢迎反馈！如果觉得好用，不妨star一下，以便让更多的人了解使用！\",\"email\":\"liaojeason@126.com\",\"address\":\"北京\",\"name\":\"jeasonlzy\",\"github\":\"https://github.com/jeasonlzy0216\",\"qq\":\"QQ交流群：489873144\",\"fullname\":\"廖子尧\"},\"des\":\"请求服务器返回Json对象\",\"method\":\"GET\",\"url\":\"http://server.jeasonlzy.com/OkHttpUtils/jsonObject\",\"ip\":\"2607:8700:101:5f42:0:0:0:8:57808\"},\"code\":0,\"msg\":\"请求成功\"}";
        Gson gson = new Gson();
        Type type = new TypeToken<ApiResult<ServerModel>>() {
        }.getType();
        ApiResult<ServerModel> apiResult = gson.fromJson(jsonTxt, type);
        ServerModel data = apiResult.getData();
        System.out.println(data);
        System.out.println(data.getAuthor());
    }

}