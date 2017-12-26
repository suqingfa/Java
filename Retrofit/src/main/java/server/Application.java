package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@SpringBootApplication
public class Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("get")
    public String[] get()
    {
        return new String[]{"a", "b", "c"};
    }

    @PostMapping("post")
    public String[] post(String[] strings)
    {
        return strings;
    }

    @GetMapping("redirect")
    public void redirect(HttpServletResponse response) throws IOException
    {
        response.sendRedirect("/get");
    }

    @GetMapping("cookie")
    public void cookie(HttpServletResponse response) throws IOException
    {
        Cookie cookie = new Cookie("name", "value");
        response.addCookie(cookie);
        response.sendRedirect("/get");
    }
}
