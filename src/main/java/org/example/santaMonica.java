package org.example;

import java.util.stream.Stream;

public class santaMonica {
    public static int mRusaIter(int n,int m){
        int suma=0;
        while(m>0){
            if (m % 2 != 0) {
                suma+=n;
            }
            n*=2;
            m/=2;
        }
        return suma;
    }

    public static int mrusarec(int n,int m){
        if(m==0){
            return 0;
        }else{
            if(m%2==0){
                return mrusarec(n*2,m/2);
            }else{
                return n+mrusarec(n*2,m/2);
            }
        }
    }

    public static int mRusaAux(int n,int m,int suma){
        if(m==0){
            return suma;
        }else{
            if (m%2!=0){
                return mRusaAux(n*2,m/2,suma+n);
            }else{
                return mRusaAux(n*2,m/2,suma);
            }
        }
    }
    public static int mRusaAux2(int n,int m ){
        return mRusaAux(n,m,0);
    }
    public static void main(String[]args){
        System.out.println(mRusaIter(50,17));
        System.out.println(mrusarec(50,17));
        System.out.println(mRusaAux2(50,17));
        System.out.println(mRusalambda(50,17));
        System.out.println(mRusalamda2(50,17));
    }

    public static int mRusalambda(int n,int m){
        return Stream.iterate(new int[] {n,m,0},i->new int[]{i[0]*2,i[1]/2,i[1]%2!=0?i[2]+i[0]:i[2]}).filter(i->i[1]==0).findFirst().map(i->i[2]).get();
    }
    public static int mRusalamda2(int n,int m){
        return Stream.iterate(new int[]{n,m,0},i->{
            if(i[1]%2!=0){
                return new int[] {i[0]*2,i[1]/2,i[2]+i[0]};
            }else{
                    return new int[]{i[0]*2,i[1]/2,i[2]};
            }}).filter(i->i[1]==0).findFirst().map(i->i[2]).get();


    }

}
