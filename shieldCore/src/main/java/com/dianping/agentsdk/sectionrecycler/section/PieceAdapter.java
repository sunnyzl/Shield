package com.dianping.agentsdk.sectionrecycler.section;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.Pair;

import com.dianping.agentsdk.framework.AgentInterface;
import com.dianping.agentsdk.framework.LinkType;
import com.dianping.agentsdk.framework.SectionCellInterface;
import com.dianping.shield.entity.CellType;

import java.lang.ref.WeakReference;

/**
 * Created by runqi.wei
 * 18:54
 * 21.06.2016.
 */
public abstract class PieceAdapter extends SectionDAdapter<MergeSectionDividerAdapter.BasicHolder> {

    protected String mappingKey = "";
    protected String hostName = "";
    protected WeakReference<AgentInterface> agentInterfaceWeakReference;
    protected WeakReference<SectionCellInterface> sectionCellInterfaceWeakReference;

    protected boolean addSpaceForDivider = false;

    public PieceAdapter(@NonNull Context context) {
        super(context);
    }

    public String getMappingKey() {
        return mappingKey;
    }

    public void setMappingKey(String mappingKey) {
        this.mappingKey = mappingKey;
    }

    public AgentInterface getAgentInterface() {
        if (agentInterfaceWeakReference != null) {
            return agentInterfaceWeakReference.get();
        }
        return null;
    }

    public void setAgentInterface(AgentInterface agentInterface) {
        this.agentInterfaceWeakReference = new WeakReference<AgentInterface>(agentInterface);
    }

    public SectionCellInterface getSectionCellInterface() {
        if (sectionCellInterfaceWeakReference != null) {
            return sectionCellInterfaceWeakReference.get();
        }

        return null;
    }

    public void setSectionCellInterface(SectionCellInterface sectionCellInterface) {
        this.sectionCellInterfaceWeakReference = new WeakReference<SectionCellInterface>(sectionCellInterface);
    }

    /**
     * Set whether should the {@link android.support.v7.widget.RecyclerView.ItemDecoration}
     * add space for dividers.
     *
     * @param addSpaceForDivider <p>
     *                           If <code>true</code> The ItemDecoration will add special space for the divider,
     *                           Thus the divider will be drawn BESIDES the item.
     *                           </p>
     *                           <p>
     *                           If <code>false</code> The ItemDecoration will NOT add special space for the divider,
     *                           Thus the divider will be drawn ON the item.
     *                           </p>
     */
    public void setAddSpaceForDivider(boolean addSpaceForDivider) {
        this.addSpaceForDivider = addSpaceForDivider;
    }

    /**
     * Retuens the {@link LinkType} to PREVIOUS section of the given section.
     *
     * @param section the section index
     * @return the LinkType
     */
    public LinkType.Previous getPreviousLinkType(int section) {
        return null;
    }

    /**
     * Returns the {@link LinkType} to NEXT section of the given section.
     *
     * @param section the section index
     * @return the LinkType
     */
    public LinkType.Next getNextLinkType(int section) {
        return null;
    }

    @Override
    public int getSectionCount() {
        return 1;
    }

    @Override
    public int getRowCount(int sectionIndex) {
        return 0;
    }

    @Override
    public float getSectionHeaderHeight(int section) {
        return NO_SPACE_HIGHT;
    }

    @Override
    public float getSectionFooterHeight(int section) {
        return NO_SPACE_HIGHT;
    }

    @Override
    public boolean hasBottomDividerVerticalOffset(int section, int position) {
        return false;
    }

    @Override
    public boolean hasTopDividerVerticalOffset(int section, int position) {
        return false;
    }

    @Override
    public Drawable getTopDivider(int section, int position) {
        return null;
    }

    @Override
    public Drawable getBottomDivider(int section, int position) {
        return null;
    }

    @Override
    public int topDividerOffset(int section, int position) {
        return NO_OFFSET;
    }

    @Override
    public int bottomDividerOffset(int section, int position) {
        return NO_OFFSET;
    }

    @Override
    public boolean showTopDivider(int section, int position) {
        return true;
    }

    @Override
    public boolean showBottomDivider(int section, int position) {
        return true;
    }

    public int getInnerType(int wrappedType) {
        return wrappedType;
    }

    public Pair<Integer, Integer> getInnerPosition(int wrappedSection, int wrappedPosition) {
        return new Pair<>(wrappedSection, wrappedPosition);
    }

    public CellType getCellType(int wrappedSection, int wrappedPosition) {
        return CellType.NORMAL;
    }

    public boolean isInnerSection(int wrappedSection) {
        return true;
    }

    public int getTotalItemCount() {
        int count = 0;
        int sectionCount = getSectionCount();
        for (int i = 0; i < sectionCount; i++) {
            count += getRowCount(i);
        }
        return count;
    }
}
