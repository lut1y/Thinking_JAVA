/**
 * Created by Dmitriy on 26.12.2019.
 */
public class Cleanup {
    public static void main(String[] args) {
        try {
            InputFile in = new InputFile("C:\\Users\\Dmitriy\\IdeaProjects\\Thinking_Java\\exceptions\\src\\Cleanupp.java");
            try {
                String s;
                int i = 1;
                while ((s = in.getLine()) != null)
                    ;
            } catch (Exception e) {
                System.out.println("Перехвачено исключение Exception в main");
                e.printStackTrace(System.out);
            } finally {
                in.dispose();
            }
        } catch (Exception e) {
            System.out.println("Ошибка при констуировании InputFile");
        }
    }
}