package com.helper;


import okhttp3.*;
import org.json.JSONObject;
import java.io.IOException;


public class QaApi {

    private static final OkHttpClient httpClient = new OkHttpClient();

//    public static void main(String[] args) throws Exception {
//        QaApi obj = new QaApi();
//    }


    public static String parse(String responseBody, String dataName) {
        JSONObject jsonObj = new JSONObject(responseBody);
        JSONObject data = (JSONObject) jsonObj.get("data");

        return data.get(dataName).toString();
    }

    public String sendGet(String endpoint, String dataName) throws Exception {

        String data;

        Request request = new Request.Builder()
                .url(GlobEnv.IOS_DB_STAGE+endpoint)
                .addHeader("token",  GlobEnv.DB_KEY)
                .get()
                .build();

        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            data = parse(response.body().string(), dataName);
        }

        return data;
    }

    private static String sendPost(String endpoint, RequestBody formBody, String dataName) throws IOException {

        String data;

        Request request = new Request.Builder()
                .url(GlobEnv.IOS_DB_STAGE+endpoint)
                .addHeader("token",  GlobEnv.DB_KEY)
                .post(formBody)
                .build();

        Response response = httpClient.newCall(request).execute();
        data = parse(response.body().string(), dataName);

        return data;
    }

    /**
     * Generate fixed amount voucher.
     *
     * @return String
     */
    public static String generateFixedAmountVoucher(String sum) throws Exception {
        RequestBody formBody = new FormBody.Builder()
                .add("sum", sum)
                .build();

        return sendPost("e2e-tests/vouchers", formBody, "code");
    }

    /**
     * Generate percentage voucher.
     *
     * @return String
     */
    public static String generatePercentageVoucher(String percent, Integer promotion) throws Exception {

        RequestBody formBody = new FormBody.Builder()
                .add("type", "percent")
                .add("value", percent)
                .add("is_promotion", Integer.toString(promotion))
                .build();

        return sendPost("e2e-tests/vouchers", formBody, "code");
    }

    /**
     * Toggle voucher activity.
     *
     * @return String
     */
    public String toggleVoucherActivity(String voucher, boolean isActive) throws IOException {

        RequestBody formBody = new FormBody.Builder()
                .add("code", voucher)
                .build();

        return sendPost("e2e-tests/vouchers/toggle", formBody, "is_active");
    }
}