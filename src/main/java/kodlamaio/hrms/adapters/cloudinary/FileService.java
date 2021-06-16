package kodlamaio.hrms.adapters.cloudinary;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.DataResult;

public interface FileService {
	DataResult<String> upload(MultipartFile multipartFile) throws IOException;
    DataResult<?> delete(int id) throws IOException;
}
