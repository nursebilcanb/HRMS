package kodlamaio.hrms.adapters.cloudinary;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.SuccessDataResult;

@Service
public class CloudinaryFileManager implements FileService{
	
	private Cloudinary cloudinary;

	@Autowired
	public CloudinaryFileManager() {
		cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "hrms-kodlama-io",
				"api_key", "696778889461736",
				"api_secret", "EnKSkrDN2hpY2zSU4CZXhKybg3Q"));
	}

	@Override
	public DataResult<?> upload(MultipartFile multipartFile) throws IOException {
		var result = this.cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.emptyMap());
		return new SuccessDataResult<>(result.get("secure_url").toString());
	}

	@Override
	public DataResult<?> delete(int id) throws IOException {
		var result = this.cloudinary.uploader().upload(id, ObjectUtils.emptyMap());
        return new SuccessDataResult<>(result);
	}

}
