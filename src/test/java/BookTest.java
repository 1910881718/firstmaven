import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.BookMapper;
import com.model.Book;
import com.util.MybatisSessionFactoryUtils;
import com.util.PageBean;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class BookTest {
    SqlSession sqlSession=null;
    BookMapper mapper=null;


    @Before
    public void before(){
        sqlSession = MybatisSessionFactoryUtils.openSession();
        mapper= sqlSession.getMapper(BookMapper.class);
    }
    @After
    public void after(){
        sqlSession.commit();
        MybatisSessionFactoryUtils.closeSession();
    }
   @Test
   public void testAdd(){
       for (int i=1;i<=50;i++){
           Book b=new Book();
           b.setBookId(1+i);
           b.setBookName("颠峰高手"+i);
           b.setBookBrief("okk");
           b.setBookPrice(98f+i);
           mapper.insert(b);
       }



      }
    @Test
      public void testDel(){

              mapper.deleteByPrimaryKey(51);

      }

    @Test
    public void testUp(){

        Book b=new Book();
        b.setBookId(1);
        b.setBookName("高手");
        b.setBookBrief("okk");
        b.setBookPrice(18f);
        mapper.updateByPrimaryKey(b);

    }
@Test
    public void testList(){
        List<Book> list = mapper.list(null);
        for (Book book : list) {
            System.out.println(book);
        }

    }

    @Test
    public void testLikeList(){
        Book b=new Book();
        b.setBookName("2");
        List<Book> list = mapper.list(b);
        for (Book book : list) {
            System.out.println(book);
        }

    }


    @Test
    public void testFyList(){
        PageBean pageBean=new PageBean();
        PageHelper.startPage(pageBean.getPage(),pageBean.getRows());
        List<Book> list = mapper.list(null);
        PageInfo pageInfo=new PageInfo(list);
        System.out.println("总条目数:"+pageInfo.getTotal());
        for (Book book : list) {
            System.out.println(book);
        }

    }



}
