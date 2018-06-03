package lomtest;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Player {
    private String nickname;
    private int lvl;
    private int hp;
    private int attack;

    private Player(Builder builder) {
        this.nickname = builder.nickname;
        this.lvl = builder.lvl;
        this.hp  = builder.hp;
        this.attack = builder.attack;
    }

    public static class Builder {
        private String nickname;
        private int lvl;
        private int hp;
        private int attack;

        public Builder(String nickname){
            this.nickname = nickname;
        }

        public Builder lvl(int lvl){
            this.lvl = lvl;
            return this;
        }

        public Builder hp(int hp){
            this.hp = hp;
            return this;
        }

        public Builder attack(int attack){
            this.attack = attack;
            return this;
        }

        public Player build(){
            return new Player(this);
        }
    }
}
