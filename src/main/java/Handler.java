import Objects.Furniture;

import java.util.ArrayList;

public class Handler {

        private ArrayList<Furniture> furnitureArrayList;

        public Handler(ArrayList<Furniture> furnitureArrayList) {
            this.furnitureArrayList = furnitureArrayList;
        }

        public void doSmth(String direction) {

            new ThreadRead(direction);

            new ThreadParse(furnitureArrayList);
        }

}
