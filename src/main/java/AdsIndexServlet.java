import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ads")
public class AdsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        Ads allAds = DaoFactory.getAdsDao(); //tool to access objects from DAO factory
        List<Ad> ads = allAds.all(); // sets adds to ads interface
        req.setAttribute("ads", ads); //puts ads in index.jsp

        // req.setAttribute("ads", DaoFactory.getAdsDao().all()); ALTERNATIVE TO THREE LINE ABOVE

        req.getRequestDispatcher("/ads/index.jsp").forward(req, res); //shows page

    }


}
