package xft.abscloud.manager.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2019-10-24.
 */
@Slf4j
public class QRCodeUtils {


    //二维码格式
    public static final String FORMAT_NAME = "jpg";
    //编码
    public static final String CHARSET = "UTF-8";

    //二维码尺寸
    public static final int QRCODE_SIZE = 400;

    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;

    /**
     * 创建二维码
     * @param url 路径
     * @return
     */
    public static BufferedImage createQrCode(String url) throws WriterException {

        try{
            Map<EncodeHintType,Object> hits = new HashMap<>();
            hits.put(EncodeHintType.CHARACTER_SET,CHARSET);
            BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE,QRCODE_SIZE,QRCODE_SIZE,hits);

            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    image.setRGB(x, y, bitMatrix.get(x, y) ? BLACK : WHITE);
                }
            }
            return image;
        }catch(Exception e){
            log.error(e.getMessage());
        }
        return null;
    }

    private static void writeToFile(BitMatrix bitMatrix, String format, File file) throws IOException {
        BufferedImage image = toBufferedImage(bitMatrix);
        if (!ImageIO.write(image, format, file)) {
            throw new IOException("Could not write an image of format " + format + " to " + file);
        }
    }

    private static BufferedImage toBufferedImage(BitMatrix bitMatrix) {
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? BLACK : WHITE);
            }
        }
        return image;
    }
}
