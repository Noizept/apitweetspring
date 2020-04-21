package com.sergio.restapi.Repository.Animenews;

import com.sergio.restapi.Entity.AnimeNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


@Repository
public class IAnimeNewsRepoImpl implements IAnimeNewsRepo {

    @Autowired
    private JdbcTemplate jtm;


    /**
     * Gets All Tweets from Database
     * @return AnimeNew
     */
    @Override
    public List<AnimeNew> getAll() {
        return jtm.query("select * from animetweet",
                new BeanPropertyRowMapper<AnimeNew>(AnimeNew.class));
    }

    /**
     * Gets The Tweet with the given ID
     * @param Id - Id of the tweet
     * @return AnimeNew
     */
    @Override
    public AnimeNew getById(Integer Id) {
        return jtm.queryForObject("select * from animetweet where id=?", new Object[] { Id },
                new BeanPropertyRowMapper<AnimeNew>(AnimeNew.class));
    }

    /**
     * Saves a Tweet into the Database
     * @param entity AnimeNew Object
     */
    @Override
    public void save(AnimeNew entity) {
        jtm.update(
                "insert into ANIMETWEET (title,link,guid,description,pubdate) " + "values(?,  ?, ?,?,?)",
                new Object[] {
                        entity.getTitle(),
                        entity.getLink(),
                        entity.getGuid(),
                        entity.getDescription(),
                        entity.getPubDate()
                });
    }

    /**
     * Batch Inserts Tweets into the Database
     * @param Entities List of AnimeNew entity
     */
    @Override
    public void saveAll(List<AnimeNew> Entities) {
        jtm.batchUpdate(
                "insert into ANIMETWEET (title,link,guid,description,pubdate,category) values(?,  ?, ?,?,?,?)",
                new BatchPreparedStatementSetter() {
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
                        ps.setString(1, Entities.get(i).getTitle());
                        ps.setString(2, Entities.get(i).getLink());
                        ps.setString(3, Entities.get(i).getGuid());
                        ps.setString(4, Entities.get(i).getDescription());
                        ps.setString(6, Entities.get(i).getCategory());

                        try {
                            ps.setObject(5, (Date) dateFormat.parse(Entities.get(i).getPubDate().toString()));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                    public int getBatchSize() {
                        return Entities.size();
                    }
                });
    }

    @Override
    public Integer count() {
        String sql= "SELECT count(*) as cnt FROM ANIMETWEET";
        return jtm.queryForObject(sql,Integer.class);
    }

    @Override
    public void truncate() {
        jtm.execute("TRUNCATE TABLE ANIMETWEET");
    }

    @Override
    /**
     * Returns X number of latest tweets
     * @param total number of rows desired
     * @return List<AnimeNew>
     */
    public List<AnimeNew> getLatest(Integer total) {
        return jtm.query("select * from animetweet order by pubdate DESC limit "+total,
                new BeanPropertyRowMapper<AnimeNew>(AnimeNew.class));
    }

    /**
     * Returns the latest Tweet
     * @return AnimeNew
     */
    @Override
    public AnimeNew getLastTweet()  throws EmptyResultDataAccessException {
        return jtm.queryForObject("select * from animetweet order by pubdate DESC limit 1",
                new BeanPropertyRowMapper<AnimeNew>(AnimeNew.class));

    }
}
