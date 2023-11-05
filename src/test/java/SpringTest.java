import com.alibaba.druid.pool.DruidDataSource;
import com.itherima.dao.BookDao;
import com.itherima.dao.NoteDao;
import com.itherima.service.BookService;
import com.itherima.service.NoteService;
import com.itherima.service.impl.NoteServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class SpringTest {
    public static void main(String[] args) {
        // 获取IOC容器
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
//        bookDao.addBook();
//        BookService bookService = (BookService) ctx.getBean("service");
//        bookService.addBook();
//
//        NoteDao noteDao = (NoteDao)ctx.getBean("noteDao");
//        noteDao.addNote();
//        NoteService noteService = (NoteService) ctx.getBean("noteService");
//        noteService.addNote();

        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        System.out.println(dataSource);
        ctx.close();
    }
}
