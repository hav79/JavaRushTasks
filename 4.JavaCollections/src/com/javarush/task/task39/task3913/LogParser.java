package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.DateQuery;
import com.javarush.task.task39.task3913.query.EventQuery;
import com.javarush.task.task39.task3913.query.IPQuery;
import com.javarush.task.task39.task3913.query.UserQuery;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery {

    private Path logDir;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public LogParser(Path logDir) {
        this.logDir = logDir;
    }

    private List<LogEvent> collectLogs() {
        File[] files = logDir.toFile().listFiles((dir, name) -> name.endsWith(".log"));
        List<String> lines = new ArrayList<>();
        Arrays.stream(files).forEach(file -> {
            try {
                lines.addAll(Files.readAllLines(file.toPath()));
            } catch (IOException e) {
            }
        });

        List<LogEvent> events = new ArrayList<>();
        for (String s : lines) {
            String[] line = s.split("\t");
            try {
                Date date = dateFormat.parse(line[2]);
                Event event = Event.valueOf(line[3].split(" ")[0]);
                Status status = Status.valueOf(line[4]);
                LogEvent logEvent = new LogEvent(line[0], line[1], date, event, status);
                if (event == Event.DONE_TASK || event == Event.SOLVE_TASK)
                    logEvent.setTaskNum(Integer.parseInt(line[3].split(" ")[1]));
                events.add(logEvent);
            } catch (ParseException e) {
            }
        }
        return events;
    }

    private boolean isDateBetween(Date current, Date after, Date before) {
        boolean d1 = after == null || current.after(after);
        boolean d2 = before == null || current.before(before);
        return d1 && d2;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        Set<String> ip = getUniqueIPs(after, before);
        return ip.size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return collectLogs().stream()
                .filter(s -> isDateBetween(s.getDate(), after, before))
                .map(LogEvent::getIp)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return collectLogs().stream()
                .filter(e -> isDateBetween(e.getDate(), after, before))
                .filter(e -> e.getUser().equals(user))
                .map(LogEvent::getIp)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return collectLogs().stream()
                .filter(e -> isDateBetween(e.getDate(), after, before))
                .filter(e -> e.getEvent() == event)
                .map(LogEvent::getIp)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return collectLogs().stream()
                .filter(e -> isDateBetween(e.getDate(), after, before))
                .filter(e -> e.getStatus() == status)
                .map(LogEvent::getIp)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getAllUsers() {
        return collectLogs().stream()
                .map(LogEvent::getUser)
                .collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        return collectLogs().stream()
                .filter(e -> isDateBetween(e.getDate(), after, before))
                .map(LogEvent::getUser)
                .collect(Collectors.toSet())
                .size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        return collectLogs().stream()
                .filter(e -> isDateBetween(e.getDate(), after, before))
                .filter(e -> e.getUser().equals(user))
                .map(LogEvent::getEvent)
                .collect(Collectors.toSet())
                .size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        return collectLogs().stream()
                .filter(e -> isDateBetween(e.getDate(), after, before))
                .filter(e -> e.getIp().equals(ip))
                .map(LogEvent::getUser)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        return collectLogs().stream()
                .filter(e -> isDateBetween(e.getDate(), after, before))
                .filter(e -> e.getEvent() == Event.LOGIN)
//                .filter(e -> e.getStatus() == Status.OK)
                .map(LogEvent::getUser)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        return collectLogs().stream()
                .filter(e -> isDateBetween(e.getDate(), after, before))
                .filter(e -> e.getEvent() == Event.DOWNLOAD_PLUGIN)
//                .filter(e -> e.getStatus() == Status.OK)
                .map(LogEvent::getUser)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        return collectLogs().stream()
                .filter(e -> isDateBetween(e.getDate(), after, before))
                .filter(e -> e.getEvent() == Event.WRITE_MESSAGE)
//                .filter(e -> e.getStatus() == Status.OK)
                .map(LogEvent::getUser)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        return collectLogs().stream()
                .filter(e -> isDateBetween(e.getDate(), after, before))
                .filter(e -> e.getEvent() == Event.SOLVE_TASK)
//                .filter(e -> e.getStatus() == Status.OK)
                .map(LogEvent::getUser)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        return collectLogs().stream()
                .filter(e -> isDateBetween(e.getDate(), after, before))
                .filter(e -> e.getEvent() == Event.SOLVE_TASK)
                .filter(e -> e.getTaskNum() == task)
//                .filter(e -> e.getStatus() == Status.OK)
                .map(LogEvent::getUser)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return collectLogs().stream()
                .filter(e -> isDateBetween(e.getDate(), after, before))
                .filter(e -> e.getEvent() == Event.DONE_TASK)
//                .filter(e -> e.getStatus() == Status.OK)
                .map(LogEvent::getUser)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        return collectLogs().stream()
                .filter(e -> isDateBetween(e.getDate(), after, before))
                .filter(e -> e.getEvent() == Event.DONE_TASK)
                .filter(e -> e.getTaskNum() == task)
//                .filter(e -> e.getStatus() == Status.OK)
                .map(LogEvent::getUser)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        return collectLogs().stream()
                .filter(e -> isDateBetween(e.getDate(), after, before))
                .filter(e -> e.getUser().equals(user))
                .filter(e -> e.getEvent() == event)
                .map(LogEvent::getDate)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        return collectLogs().stream()
                .filter(e -> isDateBetween(e.getDate(), after, before))
                .filter(e -> e.getStatus() == Status.FAILED)
                .map(LogEvent::getDate)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        return collectLogs().stream()
                .filter(e -> isDateBetween(e.getDate(), after, before))
                .filter(e -> e.getStatus() == Status.ERROR)
                .map(LogEvent::getDate)
                .collect(Collectors.toSet());
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        return collectLogs().stream()
                .filter(e -> isDateBetween(e.getDate(), after, before))
                .filter(e -> e.getUser().equals(user))
                .filter(e -> e.getEvent() == Event.LOGIN)
                .map(LogEvent::getDate)
                .sorted()
                .findFirst()
                .orElse(null);
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        return collectLogs().stream()
                .filter(e -> isDateBetween(e.getDate(), after, before))
                .filter(e -> e.getUser().equals(user))
                .filter(e -> e.getEvent() == Event.SOLVE_TASK)
                .filter(e -> e.getTaskNum() == task)
                .map(LogEvent::getDate)
                .sorted()
                .findFirst()
                .orElse(null);
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        return collectLogs().stream()
                .filter(e -> isDateBetween(e.getDate(), after, before))
                .filter(e -> e.getUser().equals(user))
                .filter(e -> e.getEvent() == Event.DONE_TASK)
                .filter(e -> e.getTaskNum() == task)
                .map(LogEvent::getDate)
                .sorted()
                .findFirst()
                .orElse(null);
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        return collectLogs().stream()
                .filter(e -> isDateBetween(e.getDate(), after, before))
                .filter(e -> e.getUser().equals(user))
                .filter(e -> e.getEvent() == Event.WRITE_MESSAGE)
                .map(LogEvent::getDate)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        return collectLogs().stream()
                .filter(e -> isDateBetween(e.getDate(), after, before))
                .filter(e -> e.getUser().equals(user))
                .filter(e -> e.getEvent() == Event.DOWNLOAD_PLUGIN)
                .map(LogEvent::getDate)
                .collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getAllEvents(after, before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        return collectLogs().stream()
                .filter(e -> isDateBetween(e.getDate(), after, before))
                .map(LogEvent::getEvent)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        return collectLogs().stream()
                .filter(e -> isDateBetween(e.getDate(), after, before))
                .filter(e -> e.getIp().equals(ip))
                .map(LogEvent::getEvent)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        return collectLogs().stream()
                .filter(e -> isDateBetween(e.getDate(), after, before))
                .filter(e -> e.getUser().equals(user))
                .map(LogEvent::getEvent)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        return collectLogs().stream()
                .filter(e -> isDateBetween(e.getDate(), after, before))
                .filter(e -> e.getStatus() == Status.FAILED)
                .map(LogEvent::getEvent)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        return collectLogs().stream()
                .filter(e -> isDateBetween(e.getDate(), after, before))
                .filter(e -> e.getStatus() == Status.ERROR)
                .map(LogEvent::getEvent)
                .collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        return collectLogs().stream()
                .filter(e -> isDateBetween(e.getDate(), after, before))
                .filter(e -> e.getEvent() == Event.SOLVE_TASK)
                .filter(e -> e.getTaskNum() == task)
//                .map(LogEvent::getEvent)
                .collect(Collectors.toSet())
                .size();
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        return collectLogs().stream()
                .filter(e -> isDateBetween(e.getDate(), after, before))
                .filter(e -> e.getEvent() == Event.DONE_TASK)
                .filter(e -> e.getTaskNum() == task)
//                .filter(e -> e.getStatus() == Status.OK)
//                .map(LogEvent::getEvent)
                .collect(Collectors.toSet())
                .size();
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        Set<Integer> tasks = collectLogs().stream()
                .filter(e -> isDateBetween(e.getDate(), after, before))
                .filter(e -> e.getEvent() == Event.SOLVE_TASK)
                .map(LogEvent::getTaskNum)
                .collect(Collectors.toSet());

        Map<Integer, Integer> solved = new HashMap<>();
        for (Integer task : tasks)
            solved.put(task, getNumberOfAttemptToSolveTask(task, after, before));
        return solved;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        Set<Integer> tasks = collectLogs().stream()
                .filter(e -> isDateBetween(e.getDate(), after, before))
                .filter(e -> e.getEvent() == Event.DONE_TASK)
                .map(LogEvent::getTaskNum)
                .collect(Collectors.toSet());

        Map<Integer, Integer> solved = new HashMap<>();
        for (Integer task : tasks)
            solved.put(task, getNumberOfSuccessfulAttemptToSolveTask(task, after, before));
        return solved;
    }
}