package dev.abhisek.portfolio.util;

import dev.abhisek.portfolio.model.Contact;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class ModelUtil {

    public static <T> List<List<T>> oneDToTwoD(List<T> list, int column) {
        List<List<T>> twoDList = new ArrayList<>();
        int rowCount = (list.size() / column) + 1;
        int index = 0;
        for (int i = 0; i < rowCount; i++) {
            List<T> row = new ArrayList<>();
            for (int j = 0; j < column; j++) {
                if (index < list.size()) {
                    row.add(list.get(index));
                    index++;
                } else {
                    row.add(null);
                }
            }
            twoDList.add(row);
        }

        return twoDList;
    }

    public static String getEncryptedToken(Contact contact) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest((
                contact.getName() +
                        contact.getEmail() +
                        contact.getPhone() +
                        contact.getMessage())
                .getBytes(StandardCharsets.UTF_8));
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
