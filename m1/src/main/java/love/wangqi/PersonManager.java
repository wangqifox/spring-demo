package love.wangqi;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: wangqi
 * @description:
 * @date: Created in 2019-01-11 11:27
 */
public class PersonManager {
    private PersonDao personDao;

    public PersonDao getPersonDao() {
        return personDao;
    }

    @Autowired
    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    public String hello() {
        System.out.println(personDao.getName());
        return "hello";
    }
}
