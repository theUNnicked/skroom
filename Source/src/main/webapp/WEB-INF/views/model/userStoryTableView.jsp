<tr class="user-story-row" style="border-color: ${userStory.storyPoints.color};">
    <td><a href="editUserStory/${userStory.id}/">#${userStory.id}</a></td>
    <td><a href="editUserStory/${userStory.id}/">${userStory.name}</a></td>
    <td><span class="user-story-round-text">P${userStory.priority}</span></td>
    <td><span class="user-story-round-text" style="background-color: ${userStory.storyPoints.color}; color: ${userStory.storyPoints.textColor};">${userStory.storyPoints.displayName}</span></td>    
    <td><span style="color: ${userStory.status.color};">${userStory.status.name}</span></td>
</tr>