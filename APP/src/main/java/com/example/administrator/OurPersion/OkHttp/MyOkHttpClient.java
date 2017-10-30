package com.example.administrator.OurPersion.OkHttp;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/6/14 0014.
 */
//---封装自己的okhttp
public class MyOkHttpClient {
    //  http://blog.csdn.net/qq_30379689/article/details/52998057
//    请求参数有三种：
//    RequestBody：普通的请求参数(一个文件)
//    FormBody.Builder：以表单的方式传递键值对的请求参数（传递多个参数）
//    MultipartBody.Builder：以表单的方式上传文件的请求参数
    public static OkHttpClient client = null;

    public static OkHttpClient getInstance() {
        if (client == null) {
            client = new OkHttpClient();
        }
        return client;

    }
    //-----------异步--------

    //--get请求
    public static void Doget(String url, Callback callback) {
        Request request = new Request.Builder().url(url).build();
        getInstance().newCall(request).enqueue(callback);
    }

    //--post表单提交参数
    public static void DoPostParms(String url, List<String> list, Callback callback) {
        FormBody.Builder builder = new FormBody.Builder();
        for (int i = 0; i < list.size(); i++) {
            builder.add("i", list.get(i));

        }
        FormBody formBody = builder.build();
        Request request = new Request.Builder().url(url).post(formBody).build();
        getInstance().newCall(request).enqueue(callback);

    }

    //--post只上传文件
    public static void DoPostFile(String url, File file, Callback callback) {
        MediaType upfile = MediaType.parse(file.getAbsolutePath());
        RequestBody requestBody = RequestBody.create(upfile, file);
        Request request = new Request.Builder().url(url).post(requestBody).build();
        getInstance().newCall(request).enqueue(callback);
    }

    //--post上传json数据
    public static void DoPostJson(String url, String parms, Callback callback) {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(JSON, parms);
        Request request = new Request.Builder().url(url).post(requestBody).build();
        getInstance().newCall(request).enqueue(callback);
    }

    //--上传多个文件
    public static void DoPostFiles(String url, List<File> list, Callback callback) {
        //判断文件类型
        MediaType mediaType = MediaType.parse(judgeType(list.get(0).getAbsolutePath()));
        MultipartBody.Builder builder = new MultipartBody.Builder();
        for (int i = 0; i < list.size(); i++) {
            builder.addFormDataPart("upload", list.get(i).getName(), RequestBody.create(mediaType, list.get(i)));
        }
        RequestBody requestBody = builder.build();
        Request request = new Request.Builder().url(url).post(requestBody).build();
        getInstance().newCall(request).enqueue(callback);
    }

    //--post上传文件加参数
    public static void DoPostFileParms(String url, List<String> string, List<File> list, Callback callback) {
//        MediaType upfile = MediaType.parse("application/octet-stream; charset=utf-8");
//        //判断文件类型
        MediaType MEDIA_TYPE = MediaType.parse(judgeType(list.get(0).getAbsolutePath()));
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        for (int i = 0; i < string.size(); i++) {
            builder.addFormDataPart("parms", string.get(i));
        }
        for (int j = 0; j < list.size(); j++) {
            builder.addFormDataPart("image", list.get(j).getName(), RequestBody.create(MEDIA_TYPE, list.get(j)));

        }
        RequestBody requestBody = builder.build();
        Request request = new Request.Builder().url(url).post(requestBody).build();
        getInstance().newCall(request).enqueue(callback);
    }

    /**
     * 根据文件路径判断MediaType
     *
     * @param path
     * @return
     */
    private static String judgeType(String path) {
        FileNameMap fileNameMap = URLConnection.getFileNameMap();
        String contentTypeFor = fileNameMap.getContentTypeFor(path);
        if (contentTypeFor == null) {
            contentTypeFor = "application/octet-stream";
        }
        return contentTypeFor;
    }

    //--下载文件
    public static void DownFile(String url, final String fileDir, final String filename) {
        final Request request = new Request.Builder().url(url).build();
        Call call = getInstance().newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    InputStream inputStream = null;
                    byte[] buf = new byte[1024];
                    int len = 0;
                    FileOutputStream fileOutputStream = null;
                    //--服务器返回的流
                    inputStream = response.body().byteStream();
                    //--创建文件夹
                    File file = new File(fileDir, filename);
                    //计算进度
                    long totalSize = request.body().contentLength();
                    long sum = 0;
                    //--将返回流读入file(以流的形式)
                    fileOutputStream = new FileOutputStream(file);
                    while ((len = inputStream.read()) != -1) {
                        sum += len;
                        //progress就是进度值
                        int progress = (int) (sum * 1.0f / totalSize * 100);
                        fileOutputStream.write(buf, 0, len);

                    }
                    fileOutputStream.flush();
                    inputStream.close();
                    fileOutputStream.close();
                }

            }
        });


    }
//    Context context;
//    public static String url = "http://218.5.136.76:50002/FeiTong/Login";
//
//    public MyOkHttpClient(Context context) {
//        this.context = context;
//    }
//
//    //post提交多个参数
//    public void post() {
//
//        MyOkHttpClient okHttpClient = new MyOkHttpClient();
//        FormBody formBody = new FormBody.Builder().add("A", "A").add("B", "B").build();
//        Request request = new  Request.Builder().url(url).post(formBody).build();
//        okHttpClient.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//            }
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//
//            }
//        });
//
//    }
//
//    //--post提交json字符串
//    public void postjson() {
//        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
//        MyOkHttpClient okHttpClient = new MyOkHttpClient();
//
//        RequestBody requestBody = RequestBody.create(JSON, "json");
//        Request request = new Request.Builder().url(url).post(requestBody).build();
//        okHttpClient.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//
//            }
//        });
//
//
//    }
//
//    //get请求
//    public void get() {
//        MyOkHttpClient okHttpClient = new MyOkHttpClient();
//        Request request = new Request.Builder().url(url).build();
//
//        Call call = okHttpClient.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                Log.e("-------", response.body().string());
//
//
//            }
//        });
//
//
//    }
//
//    //--上传文件
//    public void upfile() {
//        MediaType upfile = MediaType.parse("application/octet-stream; charset=utf-8");
//        MyOkHttpClient okHttpClient = new MyOkHttpClient();
//        File file = new File("a");
//        RequestBody requestBody = RequestBody.create(upfile, file);
//        Request request = new Request.Builder().url(url).post(requestBody).build();
//        okHttpClient.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//
//            }
//        });
//
//
//    }
//
//    //--带参上传文件
//    public void UpFileParms() {
//        MyOkHttpClient okHttpClient = new MyOkHttpClient();
//        MultipartBody.Builder builder = new MultipartBody.Builder();
//        //设置类型
//        builder.setType(MultipartBody.FORM);
//        builder.addFormDataPart("parms", "aa");
//        File file = new File("aaa");
//        builder.addFormDataPart("file", file.getName(), RequestBody.create(null, file));
//        RequestBody requestBody = builder.build();
//        Request request = new Request.Builder().url(url).post(requestBody).build();
//        okHttpClient.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//            }
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//
//            }
//        });
//
//    }


}
