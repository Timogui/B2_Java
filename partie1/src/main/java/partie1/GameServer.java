public class GameServer {
    private static volatile GameServer instance;
    private final int port;
    private int connectedPlayers = 0;

    private GameServer() {
        this.port = 8080;
    }

    public static GameServer getInstance() {
        if (instance == null) {
            synchronized (GameServer.class) {
                if (instance == null) {
                    instance = new GameServer();
                }
            }
        }
        return instance;
    }

    public synchronized void connect() {
        this.connectedPlayers++;
    }

    public synchronized int getConnectedPlayers() {
        return this.connectedPlayers;
    }
}