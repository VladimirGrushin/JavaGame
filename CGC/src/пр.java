import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProblemB {

    public static class AppScreen {
        public AppScreen() {

        }
        private Object params;
        void setParams(Object params) {
            this.params = params;
        }
        Object getParams() {
            return params;
        }
    }
    public static class ScreenManager<S extends AppScreen> {
        private final List<S> screens = new ArrayList<>();
        public ScreenManager() {

        }
        void addScreen(S screen ) {
            screens.add(screen);
        }
        void print() {
            for (S screen : screens) {
                System.out.println("Screen " + screen.getClass().getCanonicalName() + ", params = " + screen.getParams().toString());
            }
        }

        void destroy() {
            screens.clear();

        }
        void backup(Map<String, Object> map) {
            for (S screen : screens) {
                map.put(screen.getClass().getCanonicalName(), screen.getParams());
            }
        }
        void restore(Map<String, Object> map) {
            for (String key : map.keySet()) {
                try {
                    Class<?> screenClass = Class.forName(key);
                    S screen = (S) screenClass.getDeclaredConstructor().newInstance();
                    screen.setParams(map.get(key));
                    this.addScreen(screen);

                } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                         InstantiationException | IllegalAccessException ignored) {

                }
            }
        }
    }
}