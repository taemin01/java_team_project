/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

/**
 *
 * @author antaemin
 */
public class TokenUtil {
    private static final String TOKEN_FILE = System.getProperty("user.home") + File.separator + "token.json";
 // JSON 파일로 저장

    // 사용자 정보와 토큰 저장
    public static void saveUserInfo(String token, String userName, int userId, String number) throws IOException {
        JSONObject json = new JSONObject();
        json.put("token", token);
        json.put("userName", userName);
        json.put("userId", userId);
        json.put("number", number);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TOKEN_FILE))) {
            writer.write(json.toString());
        }
    }

    // 사용자 정보와 토큰 읽기
    public static JSONObject loadUserInfo() throws IOException {
        File file = new File(TOKEN_FILE);
        if (!file.exists()) return null;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder jsonStr = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonStr.append(line);
            }
            return new JSONObject(jsonStr.toString());
        }
    }

    // 토큰 파일 삭제
    public static void deleteUserInfo() {
        File file = new File(TOKEN_FILE);
        if (file.exists()) file.delete();
    }
}
