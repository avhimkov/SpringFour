package ch16;

import org.servlet.http.HttpServletRequest;
import org.springframework.web.util.WebUtils;
import org.springframework.web.util.UriUtils;

import java.io.UnsupportedEncodingException;

public class UrlUtil {
    public static String encodingUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest){
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc = null){
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;

        }
        try {

            pathSegment = UriUtils.encodingPathSegment(pathSegment, enc);

        } catch (UnsupportedEncodingException uee) {
            //
        }

        return pathSegment;
    }
}
