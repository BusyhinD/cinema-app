package cinema.dao.impl;

import cinema.dao.AbstractDao;
import cinema.dao.MovieSessionDao;
import cinema.exception.DataProcessingException;
import cinema.model.MovieSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class MovieSessionDaoImpl extends AbstractDao<MovieSession> implements MovieSessionDao {
    public static final int ONE_DAY = 1;

    public MovieSessionDaoImpl(SessionFactory factory) {
        super(factory, MovieSession.class);
    }

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        LocalDateTime startOfDay =
                ZonedDateTime.of(LocalDateTime.of(date, LocalTime.MIN), ZoneId.systemDefault())
                        .withZoneSameInstant(ZoneOffset.UTC)
                        .toLocalDateTime();
        LocalDateTime endOfDay = startOfDay.plusDays(ONE_DAY);
        try (Session session = factory.openSession()) {
            Query<MovieSession> getAvailableSessions =
                    session.createQuery("FROM MovieSession m WHERE m.movie.id = :id "
                            + "AND m.showTime >= :start AND m.showTime < :end", MovieSession.class);
            getAvailableSessions.setParameter("id", movieId);
            getAvailableSessions.setParameter("start", startOfDay);
            getAvailableSessions.setParameter("end", endOfDay);
            return getAvailableSessions.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Session for movie with id "
                    + movieId + " and show date " + date + " not found", e);
        }
    }
}
