import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.io.File;
import java.net.URL;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        String file = Main.class.getResource("map.jpg").getFile();
        String outFileDir = Main.class.getResource("/").getPath();

        /*
          按比例缩小图片到指定尺寸
          按比例缩小图片到宽和高的最大值为200,300
          宽高小于200*300时不处理
          200*600缩小成100*300
          400*300缩小成200*150
         */
        Thumbnails.of(file)
                .size(200, 300)
                .toFile(outFileDir + "200_300.jpg");

        /*
         * 不按比例缩小图片到指定尺寸
         */
        Thumbnails.of(file)
                .size(200, 300)
                .keepAspectRatio(false)
                .toFile(outFileDir + "200_300_r.jpg");

        /*
         * 按比例缩放图片
         */
        Thumbnails.of(file)
                .scale(0.5)
                .toFile(outFileDir + "0.5.jpg");

        /*
         * 旋转图片
         * 正数顺时针，负数逆时针
         */
        Thumbnails.of(file)
                .scale(1)
                .rotate(-90)
                .toFile(outFileDir + "r90.jpg");

        /*
         * 裁剪
         */
        Thumbnails.of(file)
                .scale(1)
                .sourceRegion(600, 500, 400, 400)
                .toFile(outFileDir + "region.jpg");

        /*
         * 水印
         * 位置，水印文件，透明度
         */
        Thumbnails.of(file)
                .scale(1)
                .watermark(Positions.CENTER_RIGHT, ImageIO.read( Main.class.getResourceAsStream("200_300.jpg")), 0.3f)
                .toFile(outFileDir + "watermark.jpg");

        /*
         * 改变格式
         */
        Thumbnails.of(file)
                .scale(1)
                .outputFormat("png")
                .toFile(outFileDir + "format.png");

        /*
         * 输出
         Thumbnails.of("")
         .toOutputStream(os);
         Thumbnails.of("")
         .asBufferedImage();
         */
    }
}
