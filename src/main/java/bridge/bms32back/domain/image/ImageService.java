package bridge.bms32back.domain.image;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    @Resource
    private ImageRepository imageRepository;

    public void saveCoverImage(Image image) {
        imageRepository.save(image);
    }

    public void saveSpecialImage(Image specialImage) {
        imageRepository.save(specialImage);
    }

//    public void saveImage()
}
