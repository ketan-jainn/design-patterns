/** Facade: one simple entry over several subsystem classes. */
class Cpu {
    void freeze() {
        System.out.println("CPU: freeze");
    }

    void jump(long addr) {
        System.out.println("CPU: jump " + addr);
    }

    void execute() {
        System.out.println("CPU: execute");
    }
}

class Memory {
    void load(long addr, byte[] data) {
        System.out.println("Memory: load @" + addr + " (" + data.length + " bytes)");
    }
}

class HardDrive {
    byte[] read(long lba, int size) {
        System.out.println("Disk: read lba=" + lba);
        return new byte[size];
    }
}

class ComputerFacade {
    private final Cpu cpu = new Cpu();
    private final Memory mem = new Memory();
    private final HardDrive disk = new HardDrive();

    void start() {
        cpu.freeze();
        mem.load(0, disk.read(0, 8));
        cpu.jump(0);
        cpu.execute();
    }
}

public class FacadeDemo {
    public static void main(String[] args) {
        new ComputerFacade().start();
    }
}
