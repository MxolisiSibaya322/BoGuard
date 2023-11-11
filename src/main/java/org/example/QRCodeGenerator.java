package org.example;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class QRCodeGenerator {

    public static void generateQRCode(String parameter) {
        String ipAddress = getLocalIPv4Address(); // Replace with your method to get the public IP
        String url = "http://" + ipAddress + ":7000/verify/" + parameter;

        int width = 300;
        int height = 300;

        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        try {
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            Path path = FileSystems.getDefault().getPath("src/main/resources/QRCodes/qrcode" + parameter + ".png");

            MatrixToImageWriter.writeToPath(
                    multiFormatWriter.encode(url, BarcodeFormat.QR_CODE, width, height, hints),
                    "PNG",
                    path
            );
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
    }

    public static String getLocalIPv4Address() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress() && inetAddress.getHostAddress().contains(":")) {
                        // IPv6 address, skip
                        continue;
                    }
                    return inetAddress.getHostAddress();
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return "localhost";
    }

    public static void main(String[] args) {
        generateQRCode("yourParameter");
    }
}
