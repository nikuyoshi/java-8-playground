package com.github.nikuyoshi;

class Count {
    
    private int count = 0;
    
    public void  increment(){
        this.count++;
    }
    
    @Override
    public String toString(){
        return "count: " + String.valueOf(this.count);
    }
}