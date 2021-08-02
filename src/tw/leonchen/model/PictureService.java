package tw.leonchen.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("pictureService")
@Transactional
public class PictureService {
	@Autowired
    private PictureDao pictureDao;
	
	public Picture insert(Picture bean) {
		return pictureDao.insert(bean);
	}
}
