package com.redbeemedia.enigma.core.task;

public class MockTaskFactoryProvider implements ITaskFactoryProvider {
    private ITaskFactory taskFactory = new MockTaskFactory();
    private ITaskFactory mainThreadTaskFactory = new MockTaskFactory();

    @Override
    public ITaskFactory getTaskFactory() {
        return taskFactory;
    }

    @Override
    public ITaskFactory getMainThreadTaskFactory() {
        return mainThreadTaskFactory;
    }

    public MockTaskFactoryProvider setTaskFactory(ITaskFactory taskFactory) {
        this.taskFactory = taskFactory;
        return this;
    }

    public MockTaskFactoryProvider setMainThreadTaskFactory(ITaskFactory mainThreadTaskFactory) {
        this.mainThreadTaskFactory = mainThreadTaskFactory;
        return this;
    }
}
