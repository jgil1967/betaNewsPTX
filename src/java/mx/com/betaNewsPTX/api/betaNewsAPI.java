/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.betaNewsPTX.api;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import mx.com.paquetexpress.tweet.TweetDTO;
import org.apache.commons.beanutils.BeanUtils;
import twitter4j.Status;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author jonathangil
 */

@Path("/betaNewsPTXAPI")
public class betaNewsAPI {
    private String removeUrl(String commentstr)
    {
        String urlPattern = "((https?|ftp|gopher|telnet|file|Unsure|http):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
        Pattern p = Pattern.compile(urlPattern,Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(commentstr);
        int i = 0;
        while (m.find()) {
            commentstr = commentstr.replaceAll(m.group(i),"").trim();
            i++;
        }
        return commentstr;
    }
    
 @GET
     @Produces(MediaType.APPLICATION_JSON)
    @Path("/getNews")   
 public ArrayList<TweetDTO > getNews () throws Exception{
     ConfigurationBuilder cb = new ConfigurationBuilder();
cb.setDebugEnabled(true)
  .setOAuthConsumerKey("0HeV2kVSlc3kS7X3lz9evhfIO")
  .setOAuthConsumerSecret("njqBFawphME2SHtIlC2OvtMigiyGBNxMp4F2dRGzwJXFIFX8gm")
  .setOAuthAccessToken("823298203126812675-t40wuKHuTVnlaXPeTrihFvunKDhVaRt")
  .setOAuthAccessTokenSecret("o0xK9vbNO8S428rb6fb7CIYtnSrlfv73N17qDLATn038i");
TwitterFactory tf = new TwitterFactory(cb.build());
Twitter twitter = tf.getInstance();

List<Status> statuses = twitter.getHomeTimeline();
    //System.out.println("Showing home timeline.");
    ArrayList<TweetDTO > tweets = new ArrayList<TweetDTO > ();
    TweetDTO tweet = null;
    for (Status status : statuses) {
        tweet = new TweetDTO();
        tweet.setText(removeUrl(status.getText()));
        tweet.getUser().setName(status.getUser().getName());
     //   System.out.println(status.getUser().getName() + ":" + removeUrl(status.getText()));
       // BeanUtils.copyProperties(tweet,status);
        tweets.add(tweet);
        
    }
    
 
     //System.out.println("tweets : " + tweets.size());
     return tweets;
 }
}
