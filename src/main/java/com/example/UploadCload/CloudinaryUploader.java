package com.example.UploadCload;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.io.File;
import java.util.Map;

public class CloudinaryUploader {
    private Cloudinary cloudinary;

    public CloudinaryUploader() {
        // Cấu hình Cloudinary với thông tin xác thực của bạn
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dp6tq9bwc", // Thay bằng cloud_name của bạn
                "api_key", "877344911896216", // Thay bằng api_key của bạn
                "api_secret", "A2Q9QzCbKd64cozpnItuhsZO3qM")); // Thay bằng api_secret của bạn
    }

    public String uploadImage(File file) throws Exception {
        // Upload file lên Cloudinary và nhận kết quả
        Map<String, Object> uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        // Trả về URL của ảnh đã upload
        return (String) uploadResult.get("url");
    }
}