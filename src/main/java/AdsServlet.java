import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdsServlet", urlPatterns = "/ads")
public class AdsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        Ads allAds = DaoFactory.getAdsDao();
        List<Ad> ads = allAds.all();
        req.setAttribute("ads", ads);
        req.getRequestDispatcher("/ads/index.jsp").forward(req, res);
    }


}
