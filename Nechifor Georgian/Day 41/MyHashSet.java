class MyHashSet {
        int hash;
        int key;

        List<MyHashSet> map = new ArrayList<>();
        private int hashCode(int value) {
            return (value * 1234) % 5643;
        }
        public MyHashSet() {
            super();
        }
        public MyHashSet(int key) {
            this.key = key;
            this.hash = hashCode(key);
        }

        public void add(int key) {
            map.add(new MyHashSet(key));
        }

         public void remove(int key) {
            int hash = hashCode(key);
            int size = map.size();
            for(int i = 0; i < map.size(); i++) {
                if(map.get(i).hash == hash) {
                    if(map.get(i).key == key) {
                        map.remove(i);
                        i--;
                    }
                }
            }
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            if(map.size() == 0) return false;
            for(MyHashSet s: map) {
                if(s.hash == hashCode(key)) {
                    if(s.key == key) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
