package todo;

import java.io.Serializable;

public class Task implements Serializable
{
	private String taskText = "";

	private String taskCreator;
	private String id="";
	private String taskName = "";
	private boolean followUpType;

	Task(String text, String creator, String name, boolean isFollowup)
	{
	    taskText = text;
	    taskCreator = creator;
		taskName = name;
		followUpType = isFollowup;
	}

	String getCreator()
	{
		return taskCreator;
	}

	String getTaskName()
	{
		return taskName;
	}

	String getTaskText()
	{
		return taskText;
	}

	boolean getFollowtype()
	{
		return followUpType;
	}

	void printTaskText()
	{
	    System.out.println("task text: "+taskText);
	}

	boolean updateTask(String text)
	{
		taskText=text;
		return true;
	}
}