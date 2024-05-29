public class Player extends Entity {
    private double moveAmount;
    private String name;
    private Background background;
    private boolean isWithinScreenRight;
    private boolean isWithinScreenLeft;

    public Player(Background background) {
        super(100, 10, Constants.SCREEN_WIDTH * 0.5, Constants.SCREEN_HEIGHT * 0.75, true, "idle");
        this.name = "joe";
        moveAmount = Constants.SCREEN_HEIGHT * 0.002;
        this.background = background;
        setPlayer(this);
        isWithinScreenRight = false;
        isWithinScreenLeft = false;

    }

    public String getName() {
       return name;
    }

    public void moveRight() {
        if (collided()) return;
        if (!background.moveLeft(isWithinScreenLeft)) {
            if (getX() + moveAmount < Constants.SCREEN_WIDTH - getWidth()) {
                setX(getX() + moveAmount);
                isWithinScreenRight = true;
                if (getX() + moveAmount > Constants.SCREEN_WIDTH * 0.5) {
                    isWithinScreenLeft = false;
                }
            }
        }
    }

    public void moveLeft() {
        if (collided()) return;
        if (!background.moveRight(isWithinScreenRight)) {
            if (getX() - moveAmount > 0) {
                setX(getX() - moveAmount);
                isWithinScreenLeft = true;
                if (getX() - moveAmount < Constants.SCREEN_WIDTH * 0.5) {
                    isWithinScreenRight = false;
                }
            }
        }
    }

    public void jump() {
        if (!isGrounded()) return;
        setGrounded(false);
        setGravity(3.5);
    }

    public void simulateGravity() {
        if (collided()) return;
        if (isGrounded()) return;
        setGravity(getGravity() - 0.05);
//        setY(getY() - getGravity());
        background.setYCoord(background.getDoubleYCoord() + getGravity());
        if (background.getDoubleYCoord() <= 0) {
            setGrounded(true);
        }

        for (Collidable collidable : GraphicsPanel.getCollidables()) { //move collidables with background
            collidable.setY(collidable.getY() + getGravity());
        }
    }

    public void swing() {

    }

    public void shoot() {

    }

    public void takeDamage(int damage) {
        setHealth(getHealth() - damage);
    }
}
