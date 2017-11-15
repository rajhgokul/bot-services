package com.poc.bot.controller;

import com.poc.bot.model.TokenRequest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BotController {

    Logger log = LogManager.getLogger(BotController.class);

    @GetMapping(value = "/v1/.well-known/openidconfiguration", produces = "application/json")
    public ResponseEntity getOpenIdConfiguration() {
        log.info("Inside getOpenIdConfiguration method");
        return ResponseEntity.ok("{\n" +
                "    \"issuer\": \"https://api.botframework.com\",\n" +
                "    \"authorization_endpoint\": \"https://invalid.botframework.com\",\n" +
                "    \"jwks_uri\": \"https://login.botframework.com/v1/.well-known/keys\",\n" +
                "    \"id_token_signing_alg_values_supported\": [\n" +
                "        \"RS256\"\n" +
                "    ],\n" +
                "    \"token_endpoint_auth_methods_supported\": [\n" +
                "        \"private_key_jwt\"\n" +
                "    ]\n" +
                "}");
    }

    @GetMapping(value = "/v1/.well-known/keys", produces = "application/json")
    public ResponseEntity getWellKnownKeys() {
        log.info("Inside getWellKnownKeys method");
        return ResponseEntity.ok("{\n" +
                "    \"keys\": [\n" +
                "        {\n" +
                "            \"kty\": \"RSA\",\n" +
                "            \"use\": \"sig\",\n" +
                "            \"kid\": \"e9d2Ej_yEdf2jCBDDJKVqsW-cXo\",\n" +
                "            \"x5t\": \"e9d2Ej_yEdf2jCBDDJKVqsW-cXo\",\n" +
                "            \"n\": \"1X8Pa5XWh6Ol3bLBQ5b6LN5KXe_R2W1w5IXbsNCRvabQf3Y9hgtR6ZUlSXotwrdmUzTkjpGys8rkZRp0C0FF19bMSrY8I1A6FJZXlwkeJ6VZDn76oW1eLBo4a-ec70UvhXm4sQnW3b2BWL0WLTWZng2MacDvNdq36CqmmNAPxuPs32JbtobWKivxzr5Jj_WTG6kxPJ30H-kRC1bUj7TrT464yiMDFljv-14AdDR2crEGGek9ZByW-zZaDxLwK8vyLvswn5B28S1infty1oqYUxP-NMNd9jXVIZoYhjjlhGAUs0vF5gMfFr4qUL7opOWF_hbwe9dCaTc6vN5yazMQGQ\",\n" +
                "            \"e\": \"AQAB\",\n" +
                "            \"x5c\": [\n" +
                "                \"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\"\n" +
                "            ],\n" +
                "            \"endorsements\": [\n" +
                "                \"skype\",\n" +
                "                \"msteams\"\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"kty\": \"RSA\",\n" +
                "            \"use\": \"sig\",\n" +
                "            \"kid\": \"oI2pysRK0KWZ9Jd0meQFJRHkyAE\",\n" +
                "            \"x5t\": \"oI2pysRK0KWZ9Jd0meQFJRHkyAE\",\n" +
                "            \"n\": \"ne1IUhdxcczsCYTOU3garyO2ltVnJRhl5fATBV1OGhEgEM4IneKZcpqzixnlLt-AJRqEwQH8u7sFPJWo1IlEpXK5auSLhNX3qbq7Fgzw-joWoTJwc5Gc46F03fi0pOnRzIkOrB2BXe6OyAVoQpd8sm8K7CPqD9Qkoc03i8dwG33tabHm0YS9Nw6aODPcl5F9A_YGo2KGo0-piOjX0kjoGgGnM6nbIDk5fVaXeboGHhFUwwyNd_Q8iRXmtxTAp7IZdk26beH4Zlc7NFHDqzQQKfKpGikcJKlwm0RR4y_IPaIsqQHlWZG8NMXknovaDgCZ6HuiiCq8gA22sT8pFHI5Cw\",\n" +
                "            \"e\": \"AQAB\",\n" +
                "            \"x5c\": [\n" +
                "                \"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\"\n" +
                "            ],\n" +
                "            \"endorsements\": [\n" +
                "                \"skype\",\n" +
                "                \"msteams\"\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"kty\": \"RSA\",\n" +
                "            \"use\": \"sig\",\n" +
                "            \"kid\": \"b4ysOWItD13iQfLLeBFX9lRPDtk\",\n" +
                "            \"x5t\": \"b4ysOWItD13iQfLLeBFX9lRPDtk\",\n" +
                "            \"n\": \"yk4rv691yrqBWP5BsTfhLakl3a1txN26qePK1xxQh2H6Bdy8sGwiLfoeSPFAVPHZ7-c0rn0OsLG9EudWnMPJFk4k-ECA7R-17tsKelAIRWURX7Bhr8Qzo4jhOhkg-9i--5vjmnIub8k6DvJM4qq9TsGG3OrIIH2Q-eH7PyYqzcTvJjqPJripwbsnDx2eN-zwte2vTinuYfczN_I312rK-LtTEZjOHBct5RF6ri-y64nmsn7u2l_xGFIlPCaCsbxbI9X5reIs0lJJmeoUoh2qC7X0xxcpXiDP0ThMOTtEhxBTc--AWbL15cKqsF_gOUXZCIhG_zQEz2W3sOKSmrSd0Q\",\n" +
                "            \"e\": \"AQAB\",\n" +
                "            \"x5c\": [\n" +
                "                \"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\"\n" +
                "            ],\n" +
                "            \"endorsements\": [\n" +
                "                \"skype\",\n" +
                "                \"msteams\"\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"kty\": \"RSA\",\n" +
                "            \"use\": \"sig\",\n" +
                "            \"kid\": \"GCxArXoN8Sqo7PweA7-z65denJQ\",\n" +
                "            \"x5t\": \"GCxArXoN8Sqo7PweA7-z65denJQ\",\n" +
                "            \"n\": \"uknv8y-QkKiiyc_MecJ1o4JE_5Fz94m1_y4r9-pKmyIMZI3Lx3G-pyWQzjS0UkpVB0-ujRKrvlMXPJT0npQM1hhbkHZThmHarcXXk84nqq7ZTZavwWVXjFZTh3CAY5cU65mTivc8j2Sn3u6fP_Mp4E_kyTko0PDPvRh6pum4c1_DSxC5Rg53iJ1C3r4aaTznZ0yCRw8u-AvV_5JCbPDoCH0aFAWWVB2xN9KHmkAy16ucT3KRhu74IQVATuSGSK59aqp4ZlcHgu_tGqEpt_uN2Qm0W6c8gI-2V6JTCTql8uet1jS6FuuqXzx325LTSslRJ3CjJ7uP0LOgZbnhBI96xQ\",\n" +
                "            \"e\": \"AQAB\",\n" +
                "            \"x5c\": [\n" +
                "                \"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\"\n" +
                "            ],\n" +
                "            \"endorsements\": [\n" +
                "                \"bing\",\n" +
                "                \"directline\",\n" +
                "                \"email\",\n" +
                "                \"facebook\",\n" +
                "                \"groupme\",\n" +
                "                \"kik\",\n" +
                "                \"skype\",\n" +
                "                \"slack\",\n" +
                "                \"sms\",\n" +
                "                \"telegram\",\n" +
                "                \"webchat\",\n" +
                "                \"test\"\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"kty\": \"RSA\",\n" +
                "            \"use\": \"sig\",\n" +
                "            \"kid\": \"jcZZmJ_oTfzxRl279RmddxC2rJI\",\n" +
                "            \"x5t\": \"jcZZmJ_oTfzxRl279RmddxC2rJI\",\n" +
                "            \"n\": \"w_KlTQ0psQTpNt_SHuGnZGV28apDbeeAxbAkMbpB8-mymAGZhmQChcGFxrGFRjtyryM0Y4AERDSh7jAeEaySoAIPwg0kYuXVLBkF-9nTX0WenMbtQuOs3h8I7L_SMqehAZydmQVPDFf57RxsxPrt-q2YGRnEXIp34uEQ3JpA6AK5xkpOZajOEj1W5oEGLu1NyekIojBJ0axdZcbd526TnM_NRQpvrCAd-28bkinQ6a7UDZISFgXPhp97YQvmzqZPN5kVywds8b3yt7p6qJDr4Tmxd-eETupKITpihiZcrH7sv1SmT0kjDP98SGpyiZpG7vcNNYQTbrJKHnA1__KEUQ\",\n" +
                "            \"e\": \"AQAB\",\n" +
                "            \"x5c\": [\n" +
                "                \"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\"\n" +
                "            ],\n" +
                "            \"endorsements\": [\n" +
                "                \"mswallet\"\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"kty\": \"RSA\",\n" +
                "            \"use\": \"sig\",\n" +
                "            \"kid\": \"YAJk7OgPGmt_qOu7DHj_E9cTb7s\",\n" +
                "            \"x5t\": \"YAJk7OgPGmt_qOu7DHj_E9cTb7s\",\n" +
                "            \"n\": \"3Ky8bu_G7hwuRITp3B5NsqBp4YR-yHDRRjODh4pOCirRZw5-Mu4aPCQRXXnfoL_mefgILKaEjYW6MDDlXl-3gOCZjUeUis3UbR_3XRusWzhtDwkrY3gFO6oH5h6FXLVQMGWc26nq4JwETQ6avnX_IjGbjt098V1SDHkjSHw48VRyP8ZHFE6cqnXryuE93jEpHOn1ImrBkwpmwElryvAU8Q5G_O_pDoSZ2eIN5jIZO5Eeo0ybwJSfcS6SjDE0FcWNGOJhTmK1PvtLHNWGPiRR3i1YNeCpiH0524_5r3FRS0RO2gn51j8lSreNpDk9xuG0ohLmI7z_dboHr_J3QVe3Zw\",\n" +
                "            \"e\": \"AQAB\",\n" +
                "            \"x5c\": [\n" +
                "                \"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\"\n" +
                "            ],\n" +
                "            \"endorsements\": [\n" +
                "                \"cortana\"\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"kty\": \"RSA\",\n" +
                "            \"use\": \"sig\",\n" +
                "            \"kid\": \"WyM5Su8S01KUBTIgif5sIiDT_L8\",\n" +
                "            \"x5t\": \"WyM5Su8S01KUBTIgif5sIiDT_L8\",\n" +
                "            \"n\": \"9undo92bGpW2vDOKexKBcD1N4KJslXqTwbSKsSSgQC-I-t84GqmIN0zHJK08d-dVKTDy5WuOAGO9Giz6O0_vV-DqqjeRoVwwkr_TY5X2GhoYwxY7vvtOjzQVKqYDbB4iGj9qLKDjr7mYLJRiDR9xaHxTrbMNv4oF7sXv5JWXp9ETOtO2aidEPJZjXLUKL8XDfkSzrYDj4VYNGpL5Vo-7dytwqw_KWT-6M6edgqsFOaxGXQbCslR3bpolo6d4Wf2CgKaUiBqEMPYn_rngYlopsfP-5jdadVtjYHB4cy2V2oAIKx58t5sf5cbQ56jAziqcpVlbPXMgMwyqnHAK7crEQw\",\n" +
                "            \"e\": \"AQAB\",\n" +
                "            \"x5c\": [\n" +
                "                \"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\"\n" +
                "            ],\n" +
                "            \"endorsements\": [\n" +
                "                \"skypeforbusiness\"\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"kty\": \"RSA\",\n" +
                "            \"use\": \"sig\",\n" +
                "            \"kid\": \"MPL7UeVQQ_goYAnmVtQKBeh9jyc\",\n" +
                "            \"x5t\": \"MPL7UeVQQ_goYAnmVtQKBeh9jyc\",\n" +
                "            \"n\": \"xNDianGGQb1mGbgHryefUdi25zW6xkNp8JbdtZaWXu2FqYXvW0AJ63QChplZ1uSnRnbpakFGdRNqjs5Xx9eJy5iHHvCtu5YEMIVFnRWs8pfX89OrYl_4o5TvJCTCSd_SIPjpcVOn4qT0kgVxR46G9AT0CRYAsN-cOrk-Csc8shAmdifCZseAkrhzfzH5V6f_tTx34yilSnOYwpnq2zKhUQanUsqxnyxSoIp8tLKItC4M2rxM7K1ZQblUU7zrw8I79X9ggipvmAnysqxg1E0Xe6HhLYH7PGytfGujCJK3HbT1R-2flANymxmLw6NM6W34Skqo5kUXKD7vbrRuaIcMZQ\",\n" +
                "            \"e\": \"AQAB\",\n" +
                "            \"x5c\": [\n" +
                "                \"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\"\n" +
                "            ],\n" +
                "            \"endorsements\": [\n" +
                "                \"skypeforbusiness\"\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"kty\": \"RSA\",\n" +
                "            \"use\": \"sig\",\n" +
                "            \"kid\": \"yceHp93RzmN-kd8vCnKEulqI8Zo\",\n" +
                "            \"x5t\": \"yceHp93RzmN-kd8vCnKEulqI8Zo\",\n" +
                "            \"n\": \"uWfitwq1Pr_shNl3_qmR9c4ue6TM_uc-alWs6aY1Hif7HGMdQQGLWbh-o4WDO2bXhFJPXxB0eRm-GXrHqfBB1Ne5iWiTldOFYTbLXSEiILrbAi9A2rHdAuxuWIeQDDHPOb6tII_jvHNXA24q5paXktaSV0arn4fRpOMmi_eW4QQqPK0LeTNfd4LhGpKX26o8Fc3hu9RSUUbVXo1qMYyP3U75PBWSqYVGIXnFRu9FbLP8AmSCzZB0RI5kQEZQ-zs70cCnyBp1bGZI6J_qDwFlyQmH7Y-0kCfxONAItLe7vRNnCn1104EpObqg22oFKeYuwXD2jlZILfBifl_ETQPyvw\",\n" +
                "            \"e\": \"AQAB\",\n" +
                "            \"x5c\": [\n" +
                "                \"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\"\n" +
                "            ],\n" +
                "            \"endorsements\": [\n" +
                "                \"skype\",\n" +
                "                \"msteams\"\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"kty\": \"RSA\",\n" +
                "            \"use\": \"sig\",\n" +
                "            \"kid\": \"E58u3c-zKB_0zQrLd9h6GyVr-ik\",\n" +
                "            \"x5t\": \"E58u3c-zKB_0zQrLd9h6GyVr-ik\",\n" +
                "            \"n\": \"r8lhF26IdzLOnBbZB_NSLcU2KaozloX4yKIgtUXhBCdAaHh85VrscT21jCy8laSipAxt1hswO4bwNEOkTfwDooMHn_CRyfk6Xcp83lYwy5AWQjuP6aK84aJNg8sOkVY7yJB0vy121BW4spi-f42MtBNEeYfxE-Yv7BdfFwYT8GglEQRXQ9F-zcedkNPmX18lxE15q8JX0L-o50NmxMUIsS4XN7Ipp9wtgExx9HZlObFuepyojPI4TfTyXN_bg-vjUSzjQBQVcD0ISoz36R-kmFv_pQb2DbDhgM-qgQAePBjPRy0ELuHzvGjJZ1VmHIiS1SSGPCiaq7lP5rQpBhgJjw\",\n" +
                "            \"e\": \"AQAB\",\n" +
                "            \"x5c\": [\n" +
                "                \"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\"\n" +
                "            ],\n" +
                "            \"endorsements\": [\n" +
                "                \"wechat\"\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}");
    }

    @PostMapping(value = "/botframework.com/oauth2/v2.0/token", consumes = "application/x-www-form-urlencoded", produces = "application/json")
    public ResponseEntity getToken() {
        log.info("Inside getToken method");
        return ResponseEntity.ok("{\n" +
                "\t\"token_type\": \"Bearer\",\n" +
                "\t\"expires_in\": 3599,\n" +
                "\t\"ext_expires_in\": 0,\n" +
                "\t\"access_token\": \"eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IjJLVmN1enFBaWRPTHFXU2FvbDd3Z0ZSR0NZbyIsImtpZCI6IjJLVmN1enFBaWRPTHFXU2FvbDd3Z0ZSR0NZbyJ9.eyJhdWQiOiJodHRwczovL2FwaS5ib3RmcmFtZXdvcmsuY29tIiwiaXNzIjoiaHR0cHM6Ly9zdHMud2luZG93cy5uZXQvZDZkNDk0MjAtZjM5Yi00ZGY3LWExZGMtZDU5YTkzNTg3MWRiLyIsImlhdCI6MTUxMDczNjUyNSwibmJmIjoxNTEwNzM2NTI1LCJleHAiOjE1MTA3NDA0MjUsImFpbyI6IlkyTmdZSGlXeXYrbThJQnpoR3lOVlp1SjRWY09BQT09IiwiYXBwaWQiOiI0OGY1ZDBkNy04MDRlLTQyZTUtOTZmMi1mNTllZDhiNmNlMjQiLCJhcHBpZGFjciI6IjEiLCJpZHAiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC9kNmQ0OTQyMC1mMzliLTRkZjctYTFkYy1kNTlhOTM1ODcxZGIvIiwidGlkIjoiZDZkNDk0MjAtZjM5Yi00ZGY3LWExZGMtZDU5YTkzNTg3MWRiIiwidmVyIjoiMS4wIn0.P7vXX8Vs7N9iOkkUCRMpxcR40yaSs3DY4VVTX-TmXXKQnpQOFfzk8q9-QQ-KYLDGFcHxwj-WGUHSL00s03dOtUC0slOrjZS5aCxMd_TVdFCUamclykc38rM8X2AK9gTSfnamiOxrkr5h2pE3yDtKUI_lTWDaYn5aCXU3SbwKS9XWxZozWg733hHZ-Xtka7a6i0b2Ham3iY1IByQH3LYWTTe75SwtmTnFyhI9z6Sx0qb0N2ZSZ5BehqRqvrS5XDhffDO3T3If9SZo9e-ZYT3FEl5CuAJgYkMzB29JfS1xVnGm4E-IwyrOXYd0ySkK2eVRant8AQwvL1-xV8G6ZinMYA\"\n" +
                "}");
    }
}
