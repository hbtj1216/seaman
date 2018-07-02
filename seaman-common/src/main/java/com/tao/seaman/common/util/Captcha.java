package com.tao.seaman.common.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * 验证码工具类
 *
 * @creater tao
 * @time 2018/6/17
 */
public class Captcha {

    /**
     * 验证码图片的宽度, 默认160px
     */
    private int width = 160;

    /**
     * 验证码图片的高度, 默认40px
     */
    private int height = 40;

    /**
     * 验证码字符个数, 默认4
     */
    private int codeCount = 4;

    /**
     * 验证码干扰线个数, 默认20
     */
    private int lineCount = 20;

    /**
     * 验证码
     */
    private String code = null;

    /**
     * 验证码图片
     */
    private BufferedImage buffImage = null;

    /**
     * 随机函数对象
     */
    Random random = new Random();

    public Captcha() {
        createImage();
    }

    public Captcha(int width, int height) {
        this.width = width;
        this.height = height;
        createImage();
    }

    public Captcha(int width, int height, int codeCount) {
        this.width = width;
        this.height = height;
        this.codeCount = codeCount;
        createImage();
    }

    public Captcha(int width, int height, int codeCount, int lineCount) {
        this.width = width;
        this.height = height;
        this.codeCount = codeCount;
        this.lineCount = lineCount;
        createImage();
    }

    /**
     * 生成验证码图片
     */
    private void createImage() {
        // 字体的宽度
        int fontWidth = width / codeCount;
        // 字体的高度
        int fontHeight = height - 4;
        int codeY = height - 8;

        // 图像buffer
        buffImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = buffImage.getGraphics();
        // 设置背景色
        graphics.setColor(getRandomColor(200, 250));
        graphics.fillRect(0, 0, width, height);

        // 设置字体
        Font font = new Font("Fixedsys", Font.BOLD, fontHeight);
        graphics.setFont(font);

        // 设置干扰线
        for (int i = 0; i < lineCount; i++) {
            int xs = random.nextInt(width);
            int ys = random.nextInt(height);
            int xe = xs + random.nextInt(width);
            int ye = ys + random.nextInt(height);
            graphics.setColor(getRandomColor(1, 255));
            graphics.drawLine(xs, ys, xe, ye);
        }

        // 添加噪点
        float yawpRate = 0.01f;// 噪声率
        int area = (int) (yawpRate * width * height);
        for (int i = 0; i < area; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);

            buffImage.setRGB(x, y, random.nextInt(255));
        }

        // 得到随机字符
        String str1 = randomStr(codeCount);
        this.code = str1;
        for (int i = 0; i < codeCount; i++) {
            String strRand = str1.substring(i, i + 1);
            graphics.setColor(getRandomColor(1, 255));
            // g.drawString(a,x,y);
            // a为要画出来的东西，x和y表示要画的东西最左侧字符的基线位于此图形上下文坐标系的 (x, y) 位置处
            graphics.drawString(strRand, i * fontWidth + 10, codeY);
        }
    }

    /**
     * 得到随即字符
     *
     * @param count 字符的总个数
     * @return
     */
    private String randomStr(int count) {
        String str1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        String res = "";
        int len = str1.length() - 1;
        double index;
        for (int i = 0; i < count; i++) {
            index = (Math.random()) * len;
            res = res + str1.charAt((int) index);
        }
        return res;
    }

    /**
     * 得到随机颜色
     * @param fc 最小颜色值
     * @param bc 最大颜色值
     * @return
     */
    private Color getRandomColor(int fc, int bc) {// 给定范围获得随机颜色
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    /**
     * 产生随机字体
     * @param size
     * @return
     */
    private Font getFont(int size) {
        Random random = new Random();
        Font[] font = new Font[5];
        font[0] = new Font("Ravie", Font.PLAIN, size);
        font[1] = new Font("Antique Olive Compact", Font.PLAIN, size);
        font[2] = new Font("Fixedsys", Font.PLAIN, size);
        font[3] = new Font("Wide Latin", Font.PLAIN, size);
        font[4] = new Font("Gill Sans Ultra Bold", Font.PLAIN, size);
        return font[random.nextInt(5)];
    }

    /**
     * 扭曲方法
     * @param g
     * @param w1
     * @param h1
     * @param color
     */
    private void shear(Graphics g, int w1, int h1, Color color) {
        shearX(g, w1, h1, color);
        shearY(g, w1, h1, color);
    }

    /**
     * 扭曲
     * @param g
     * @param w1
     * @param h1
     * @param color
     */
    private void shearX(Graphics g, int w1, int h1, Color color) {

        int period = random.nextInt(2);

        boolean borderGap = true;
        int frames = 1;
        int phase = random.nextInt(2);

        for (int i = 0; i < h1; i++) {
            double d = (double) (period >> 1)
                    * Math.sin((double) i / (double) period
                    + (6.2831853071795862D * (double) phase)
                    / (double) frames);
            g.copyArea(0, i, w1, 1, (int) d, 0);
            if (borderGap) {
                g.setColor(color);
                g.drawLine((int) d, i, 0, i);
                g.drawLine((int) d + w1, i, w1, i);
            }
        }
    }

    /**
     * 扭曲Y
     * @param g
     * @param w1
     * @param h1
     * @param color
     */
    private void shearY(Graphics g, int w1, int h1, Color color) {

        int period = random.nextInt(40) + 10; // 50;

        boolean borderGap = true;
        int frames = 20;
        int phase = 7;
        for (int i = 0; i < w1; i++) {
            double d = (double) (period >> 1)
                    * Math.sin((double) i / (double) period
                    + (6.2831853071795862D * (double) phase)
                    / (double) frames);
            g.copyArea(i, 0, 1, h1, 0, (int) d);
            if (borderGap) {
                g.setColor(color);
                g.drawLine(i, (int) d, i, 0);
                g.drawLine(i, (int) d + h1, i, h1);
            }
        }
    }

    /**
     * 输出产生的验证码图片到流
     * @param sos
     * @throws IOException
     */
    public void write(OutputStream sos) throws IOException {
        ImageIO.write(buffImage, "png", sos);
        sos.close();
    }

    /**
     * 获得验证码图片
     * @return
     */
    public BufferedImage getBuffImage() {
        return buffImage;
    }

    /**
     * 获得验证码
     * @return
     */
    public String getCode() {
        return code.toLowerCase();
    }

    public static void main(String[] args) {
        Captcha captcha = new Captcha();
        try {
            captcha.write(new FileOutputStream(new File("D:/chptcha1.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String code = captcha.getCode();
        System.out.println(code);
    }
}













