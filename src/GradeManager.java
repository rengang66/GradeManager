/**
 * @author rengang
 * 
 */
public class GradeManager {

	/*
	private static int MD_Single = 1;
	private static int MD_Parent = 2;
	private static int MD_Child = 3;
	private static int MD_multi = 4;
	private static int MO_inherit = 1;
	private static int MO_terminate = 2;
   */
	
	public GradeManager() {
		super();		
	}

	public boolean verify(ManagingDirector mD, ManagedObject mO, 
			ManageMode mM, int MD_policy, int MO_policy) {
		boolean verify = false;
		if (isExist(mD, mO, mM))
			return true;
		switch (MD_policy) {
		case 1: {			
			if ( MO_policy == 1 ){
				while( mO == null){					
					if (isExist(mD, mO, mM))
					{ verify = true ; break ;}
					mO = getParent(mO);
				}
			}
			else if ( MO_policy == 2){
				if (isExist(mD, mO, mM)){ verify = true ; }
			}
		}
		case 2:
			while(  mD == null ){
				if ( MO_policy == 1 ){
					while( mO == null){					
						if (isExist(mD, mO, mM))
						{ verify = true ; break ;}
						mO = getParent(mO);
					}
				}
				else if ( MO_policy == 2){
					if (isExist(mD, mO, mM)){ verify = true ; }
				}
				mD = getParent(mD);
			}			
		case 3:
            // 这里还是一个递归算法
			while(  mD == null ){
				ManagingDirector[] md = getChild(mD);
				for (int i = 1; i < md.length ; i++){
					
				}
				
			}
			
		case 4:
			
		default:
			//ma = "ww";

		}

		return verify;
	}
	
	public boolean ManagingDirectorverify(ManagingDirector mD,
			ManagedObject mO, ManageMode mM, int MD_policy, int MO_policy) {
		boolean verify = false;
		if (MO_policy == 1) {
			switch (MD_policy) {
			case 1: {
				while (mO == null) {
					if (isExist(mD, mO, mM)) {verify = true;}
					mO = getParent(mO);
				}
			}
			case 2:
				while (mO == null) {
					verify = InheritParent(mD, mO, mM);
					mO = getParent(mO);
				}
			case 3:
				while (mO == null) {
					verify = ExtendChild(mD, mO, mM);
					mO = getParent(mO);
				}
			case 4: {
				while (mO == null) {
					if (!InheritParent(mD, mO, mM)) {verify = ExtendChild(mD, mO, mM);					} 
					else {	verify = true;	}
				}
				mO = getParent(mO);
			}
			}

		} else if (MO_policy == 2) {
			switch (MD_policy) {
			case 1: {
				if (isExist(mD, mO, mM)) {	verify = true;	}
			}
			case 2:
				verify = InheritParent(mD, mO, mM);
			case 3:
				verify = ExtendChild(mD, mO, mM);
			case 4: {
				if (!InheritParent(mD, mO, mM)) {verify = ExtendChild(mD, mO, mM);	} 
				else {verify = true;}}
			}
		}
		return verify;
	}
	

	
	
	public boolean isExist(ManagingDirector mD, ManagedObject mO, ManageMode mM) {
		boolean isExist = false;
		// 验证初始化信息
		return isExist;
	}
	
	public ManagedObject getParent(ManagedObject mO){
		ManagedObject mo = null;
		// 获取该ManagedObject对象的父结点对象
		return mo;
	}
	
	public ManagedObject[] getChild(ManagedObject mO){
		ManagedObject[] mo = null;
        // 获取该ManagedObject对象的下一级全部子结点对象，形成对象组
		return mo;
	}
	
	public ManagingDirector getParent(ManagingDirector mO){
		ManagingDirector md = null;
        //	获取该ManagingDirector对象的父结点对象
		return md;
	}
	
	public ManagingDirector[] getChild(ManagingDirector mO){
		ManagingDirector[] md = null;
        //	获取该ManagingDirector对象的下一级全部子结点对象，形成对象组
		return md;
	}
	
	public boolean InheritParent(ManagingDirector mD, ManagedObject mO,
			ManageMode mM) {
		boolean verify = false;
		while (mD == null) {
			if (isExist(mD, mO, mM)) {verify = true;break;}
			mD = getParent(mD);
		}
		return verify;
	}	
	
	public boolean ExtendChild(ManagingDirector mD, ManagedObject mO, 
			ManageMode mM) {
		boolean verify = false;
		ManagingDirector[] md = getChild(mD);
		if ( md == null) { return false; }
		for (int i = 1; i < md.length; i++) {
			mD = md[i];
			if ( ExtendChild(mD, mO, mM) ){return true;};			
			if ( isExist(mD, mO, mM)) {verify = true;break;}			
		}
		return verify;
	}
	
	public boolean ExtendObject(ManagingDirector mD, ManagedObject mO, 
			ManageMode mM) {
		boolean verify = false;
		while( mO == null){					
			if (isExist(mD, mO, mM)){ verify = true ; break ;}
			mO = getParent(mO);
		}
		return verify;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	public boolean verify(String[] MA, String[] MO, String MM) {
		boolean verify = false;
		int m = 10, n = 10;
		for (int j = 1; j < n; j++) {
			if (MO[j] == MM) {
				for (int i = 1; i < m; i++) {
					if (isExist(MA[i], MO[j], MM)) {
						verify = true;
						return verify;
					}
				}
			}
		}
		return verify;
	}
*/

}
